var Sentinel = {
    
    init: function() {
        this.menubar = this.menubar||$('#layout-menubar');
        this.menubarElement = this.menubar.get(0);
        this.menubarContainer = this.menubarContainer||this.menubar.children('ul.layout-menubar-container');
        this.content = $('#layout-portlets-cover');
        
        this.bindEvents();
    },
            
    initTopMenu: function() {
        var $this = this;
        this.topMenu = $('#sm-topmenu');
        this.topMenuItems = this.topMenu.children('li');

        this.topMenuItems.on('mouseenter', function() {
            if($(window).width() < 640) {
                return;
            }
            
            if($this.topMenuHideTimeout) {
                clearTimeout($this.topMenuHideTimeout);
            }

            var item = $(this);
            if($this.activeTopMenuItem && $this.activeTopMenuItem.get(0) !== item.get(0)) {
                $this.hideTopMenuItem($this.activeTopMenuItem);
            }

            $this.activeTopMenuItem = item;
            item.children('ul').show();
        })
        .on('mouseleave', function() {
            if($(window).width() < 640) {
                return;
            }
            
            var item = $(this);
            $this.topMenuHideTimeout = setTimeout(function() {
                $this.hideTopMenuItem(item);
                $this.activeTopMenuItem = null;
            }, 1000);
        })
        .on('click', function() {
            var item = $(this);
            if($(window).width() <= 640) {
                if(item.hasClass('active-topmenuitem') && item.children('ul').is(':visible')) {
                    item.removeClass('active-topmenuitem').children('ul').css('display', 'none');
                }
                else {
                    item.addClass('active-topmenuitem').siblings('.active-topmenuitem').removeClass('active-topmenuitem').children('ul').hide();
                    item.children('ul').css('display', 'block');
                }
            }
            else {
                item.children('ul').toggle();
            }
        });
    },
    
    hideTopMenuItem: function(item) {
        item.children('ul').hide();
    },
            
    toggleLeftMenu: function() {
        if(this.menubar.hasClass('slimmenu')) {
            this.menubar.removeClass('slimmenu');
            $('#searchArea').removeClass('slimsearch');
            PrimeFaces.setCookie('sentinel_menumode', 'large');
        }
        else {
            this.menubar.addClass('slimmenu').removeClass('layout-menubar-open-fullscr');
            $('#searchArea').addClass('slimsearch');
            PrimeFaces.setCookie('sentinel_menumode', 'slim');
        }
        
        this.menubar.addClass('OvHidden').scrollTop(0).removeClass('OvHidden');
        $('body').removeClass('OvHidden'); 
    },
    
    bindEvents: function() {
        this.initTopMenu(); 
        
        var $this = this;
        
        //menubar resize btn binding
        $('#layout-menubar-resize').on('click', function(e) {
            Sentinel.toggleLeftMenu();
            e.preventDefault();
        });

        // responsive mode menubar open button
        $('#layout-menubar-resize2').on('click', function(e) {
            if($this.menubar.hasClass('layout-menubar-open-fullscr')) {
                $this.menubar.removeClass('layout-menubar-open-fullscr');
                $('body').removeClass('OvHidden');
            }
            else {
                $this.menubar.addClass('layout-menubar-open-fullscr').removeClass('slimmenu');
                $('#searchArea').removeClass('slimsearch');
                $('body').addClass('OvHidden');
            }
            
            e.preventDefault();
        });

        // responsive mode header bar open menus binding
        $('#sm-mobiletopmenu').on('click', function() {
            if($('#sm-topmenu').is(':visible')) {
                $('#sm-topmenu').removeClass('DispBlock');
            }
            else {
                $('#sm-topmenu').addClass('DispBlock');              
            }
        });

        // login
        this.loginBox = $('#login-box');
        if(this.loginBox.length) {
            this.tabHeaders = this.loginBox.find('.TabBtn');
            this.tabContents = this.loginBox.find('.TabContent');
            this.tabHeaders.on('click', function(e) {
                $this.tabHeaders.removeClass('TabBtnActiveLeft TabBtnActiveRight');
                $this.tabContents.addClass('DispNone');

                if($(this).hasClass('left')) {
                    $(this).addClass('TabBtnActiveLeft');
                    $('#TAB' + $(this).attr('role')).removeClass('DispNone');
                } else {
                    $(this).addClass('TabBtnActiveRight');
                    $('#TAB' + $(this).attr('role')).removeClass('DispNone');
                }
                
                e.preventDefault();
            });
        }      
        
        //remove transitions on IOS
        if(this.isIOS()) {
            this.menubar.find('a').addClass('notransition');
        }
        
        //workaround for firefox bug of not resetting scrolltop
        if(navigator.userAgent.toLowerCase().indexOf('firefox') > -1) {
            $(window).on('resize', function() {
                $this.menubarElement.scrollTop = 0;
            });
        }
    },
    
    //backward compatibilitys
    openSubMenu: function(element) {
        this.toggleSubMenu(element);
    },
            
    toggleSubMenu: function(element) {
        var link = $(element),
        menuitem = link.closest('li'),
        subMenuContainer = menuitem.children('ul.layout-menubar-submenu-container');

        if(menuitem.parent().is(this.menubarContainer)) {
            this.menubarContainer.find('> li.layout-menubar-active').removeClass('layout-menubar-active');
            menuitem.addClass('layout-menubar-active');
        }

        if(subMenuContainer.length) {
            if(subMenuContainer.is(':visible')) {
                subMenuContainer.hide();
                menuitem.removeClass('layout-menubar-active');
                this.clearMenuState();
            }
            else {
                subMenuContainer.slideDown(300);
                menuitem.siblings().find('ul').slideUp(300);
                this.activeMenuitemId = menuitem.attr('id');
                this.saveMenuState();
            }
        }
        else {
            this.activeMenuitemId = menuitem.attr('id');
            this.saveMenuState();
        }
    },

    toggleCodes: function(on) {
        var obj = document.getElementById('icons');

        if (on) {
            obj.className += ' codesOn';
        } else {
            obj.className = obj.className.replace(' codesOn', '');
        }
    },
            
    restoreMenuState: function() {
        this.activeMenuitemId = PrimeFaces.getCookie('sentinel_activemenuitem');
        this.menubar = $('#layout-menubar');
        this.menubarContainer = this.menubar.children('ul.layout-menubar-container');
        
        if(PrimeFaces.getCookie('sentinel_menumode') === 'slim') {
            this.menubar.addClass('slimmenu');
            $('#searchArea').addClass('slimsearch');
        }

        if(this.activeMenuitemId) {
            this.menubarContainer.find('> li.layout-menubar-active').removeClass('layout-menubar-active');
            this.restoreMenuitem($(document.getElementById(this.activeMenuitemId)));
        }
    },
    
    restoreMenuitem: function(menuitem) {
        var subMenuContainer = menuitem.children('ul.layout-menubar-submenu-container');
    
        subMenuContainer.show();
        
        if(menuitem.parent().hasClass('layout-menubar-submenu-container')) {
            this.restoreMenuitem(menuitem.parent().parent());
        }
        else {
            menuitem.addClass('layout-menubar-active')
        }
    },
    
    saveMenuState: function() {
        PrimeFaces.setCookie('sentinel_activemenuitem', this.activeMenuitemId);
        PrimeFaces.setCookie('sentinel_menumode', this.menubar.hasClass('slimmenu') ? 'slim' : 'large');
    },
    
    clearMenuState: function() {
        PrimeFaces.setCookie('sentinel_activemenuitem', null);
        PrimeFaces.setCookie('sentinel_menumode', null);
    },
    
    isIOS: function() {
        return ( navigator.userAgent.match(/(iPad|iPhone|iPod)/g) ? true : false );
    }
         
};

$(function() {
    Sentinel.init();
});