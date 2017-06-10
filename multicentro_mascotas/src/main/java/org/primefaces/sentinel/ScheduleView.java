/*    */package org.primefaces.sentinel;

/*    */
/*    */import java.util.Calendar;
import java.util.Date;
import java.util.Random;


/*    */
import org.primefaces.model.DefaultScheduleEvent;
/*    */
import org.primefaces.model.LazyScheduleModel;

/*    */
/*    */class ScheduleView$1 extends LazyScheduleModel
/*    */{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*    */public void loadEvents(Date start, Date end)
	/*    */{

		/* 45 */Date random = getRandomDate(start);
		/* 46 */addEvent(new DefaultScheduleEvent("Lazy Event 1", random,
				random));
		/*    */
		/* 48 */random = this.getRandomDate(start);
		/* 49 */addEvent(new DefaultScheduleEvent("Lazy Event 2", random,
				random));
		/*    */}

	/*    */

	public Date getRandomDate(Date base)
	{
	Calendar date = Calendar.getInstance();
	date.setTime(base);
	date.add(Calendar.DATE, ((int)(Math.random()*30))+1 );
	return date.getTime();
}
}

/*
 * Location: C:\Users\jbravo\Desktop\classes\ Qualified Name:
 * org.primefaces.sentinel.ScheduleView JD-Core Version: 0.6.0
 */