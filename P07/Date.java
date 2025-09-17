class Date{
  private int day;
  private int month;
  private int year; 

  public Date(int pDay, int pMonth, int pYear){
    if (!validateYear(pYear)) {
        throw new IllegalArgumentException("Invalid year: " + pYear);
    }
    if (!validateMonth(pMonth)) {
        throw new IllegalArgumentException("Invalid month: " + pMonth);
    }
    if (!validateDay(pDay, pMonth, pYear)) {
        throw new IllegalArgumentException(
            "Invalid day for " + pDay + "/" + pMonth + "/" + pYear
        );
    }

    this.day = pDay;
    this.month = pMonth;
    this.year = pYear;
  }

  private boolean validateYear(int year){
    int min = 1800;
    int max = 9999;
    boolean boolValue = false;
    if (year >= 1800 && year <= 9999){
      boolValue = true;
    }
    return boolValue;
  }

  private boolean validateMonth(int month){
    boolean boolValue = false;
    if (month >= 1 && month <= 12 ){
      boolValue = true;
    }
    return boolValue;
  }

  private boolean validateDay(int day, int month, int year){
    boolean boolValue = false;
    if (day >= 1 && day <= 31) {
      switch (month) {
        case 2: {
          boolean leapYear = isLeapYear(year);
          if ((day <= 28) || (leapYear && day == 29)) {
            boolValue = true;
          }
          break;
        }
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
          if (day <= 31) { boolValue = true; }
          break;
        case 4: case 6: case 9: case 11:
          if (day <= 30) { boolValue = true; }
          break;
        default:
          break;
      }
    }
    return boolValue;
  }

  public boolean isLeapYear(int year){
    boolean boolValue = false;
    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
      boolValue = true;
    }
    return boolValue;
  }

  public String getSuffix() {
    int teen = day % 100;
    if (teen >= 11 && teen <= 13) {
        return "th"; // ✅ special case
    }
    switch (day % 10) {
        case 1:  return "st";
        case 2:  return "nd";
        case 3:  return "rd";
        default: return "th";
    }
  }

  public int getDay()   { return day; }
  public int getMonth() { return month; }
  public int getYear()  { return year; }

  public void setDay(int pDay){
      if (validateDay(pDay, month, year)) {
        this.day = pDay;
      }
      throw new IllegalArgumentException("Invalid day: " + pDay);
    } 

  public void setMonth(int pMonth){
      if (validateMonth(pMonth)) {
        this.month = pMonth;
      }
      throw new IllegalArgumentException("Invalid month: " + pMonth);
  }

  public void setYear(int pYear){
      if (validateYear(pYear)) {
        this.year = pYear;
      }
      throw new IllegalArgumentException("Invalid year: " + pYear);
  }

  public String toString()
  {
    String dateString;
    dateString = "Day: " + getDay() + " Month: " + getMonth() + " Year: " + getYear();
    return dateString;
  }

  public boolean equals(Date pObject)
  {
    boolean isEqual = false;
    Date inDate = null;
      if(pObject instanceof Date)
      {
        inDate = (Date)pObject;
        if (day == inDate.getDay() && month == inDate.getMonth() && year == inDate.getYear()) {
          isEqual = true;
        }
      }
      return isEqual;
  }

}

class DateTime extends Date {
    private int hours;
    private int minutes;
    private int seconds;

    // Use a clear order: (day, month, year, hour, minute, second)
    public DateTime(int pDay, int pMonth, int pYear, int pHr, int pMin, int pSec) {
        super(pDay, pMonth, pYear); // must be first
        if (!validateTime(pHr, pMin, pSec)) {
            throw new IllegalArgumentException("Invalid time: " + pHr + ":" + pMin + ":" + pSec);
        }
        this.hours = pHr;
        this.minutes = pMin;
        this.seconds = pSec;
    }

    private static boolean validateTime(int h, int m, int s) {
        return (0 <= h && h < 24) && (0 <= m && m < 60) && (0 <= s && s < 60);
    }

    // (Optional) getters
    public int getHours() { return hours; }
    public int getMinutes() { return minutes; }
    public int getSeconds() { return seconds; }
}
