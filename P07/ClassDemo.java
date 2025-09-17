import java.util.*;
public class ClassDemo {
  public static void main(String[] args) {
   // 1. Valid dates
        System.out.println("=== Valid Dates ===");
        Date d1 = new Date(15, 8, 2025);
        System.out.println(d1); // expect: 15th/08/2025

        Date d2 = new Date(29, 2, 2024); // leap year
        System.out.println(d2); // expect: 29th/02/2024

        Date d3 = new Date(1, 1, 2025);
        System.out.println(d3); // expect: 1st/01/2025

        Date d4 = new Date(2, 1, 2025);
        System.out.println(d4); // expect: 2nd/01/2025

        Date d5 = new Date(3, 1, 2025);
        System.out.println(d5); // expect: 3rd/01/2025

        Date d6 = new Date(11, 1, 2025);
        System.out.println(d6); // expect: 11th/01/2025 (special teen case)

        // 2. Invalid dates
        System.out.println("\n=== Invalid Dates (should throw) ===");
        try { new Date(31, 4, 2025); }   // April has 30 days
        catch (Exception e) { System.out.println("Caught: " + e.getMessage()); }

        try { new Date(29, 2, 2025); }   // 2025 not leap year
        catch (Exception e) { System.out.println("Caught: " + e.getMessage()); }

        try { new Date(0, 10, 2025); }   // invalid day
        catch (Exception e) { System.out.println("Caught: " + e.getMessage()); }

        try { new Date(10, 13, 2025); }  // invalid month
        catch (Exception e) { System.out.println("Caught: " + e.getMessage()); }

        try { new Date(10, 10, 1500); }  // invalid year
        catch (Exception e) { System.out.println("Caught: " + e.getMessage()); }

        // 3. Setters
        System.out.println("\n=== Setters ===");
        Date d7 = new Date(28, 2, 2024); // leap year Feb
        System.out.println("Original: " + d7);
        d7.setDay(29); // should work (leap year)
        System.out.println("After setDay(29): " + d7);

        try {
            d7.setMonth(4); // April 29th invalid
        } catch (Exception e) {
            System.out.println("Caught when setting month: " + e.getMessage());
        }

        try {
            d7.setYear(2025); // 29 Feb invalid in 2025
        } catch (Exception e) {
            System.out.println("Caught when setting year: " + e.getMessage());
        }

        // 4. Equality
        System.out.println("\n=== Equality ===");
        Date d8 = new Date(15, 8, 2025);
        System.out.println("d1.equals(d8)? " + d1.equals(d8)); // expect true
        System.out.println("d1.equals(d2)? " + d1.equals(d2)); // expect false
                                                               //
  }
}
