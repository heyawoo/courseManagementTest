package com.example.domain;

import java.io.Serializable;

public class RegistCourseInfo implements Serializable {

	private String no;
	private String name;
	private String thedate;
	private String weekday;
	private String start;
	private String end;
	private String extra;
	
	public RegistCourseInfo() {
	}

	public RegistCourseInfo(String no, String name, String thedate, String weekday, String start, String end,
			String extra) {
		super();
		this.no = no;
		this.name = name;
		this.thedate = thedate;
		this.weekday = weekday;
		this.start = start;
		this.end = end;
		this.extra = extra;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThedate() {
		return thedate;
	}

	public void setThedate(String thedate) {
		this.thedate = thedate;
	}

	public String getWeekday() {
		return weekday;
	}

	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return "RegistCourseInfo [no=" + no + ", name=" + name + ", thedate=" + thedate + ", weekday=" + weekday
				+ ", start=" + start + ", end=" + end + ", extra=" + extra + "]";
	}
	
	
	
}
