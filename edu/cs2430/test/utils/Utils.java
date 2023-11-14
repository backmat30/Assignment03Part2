package edu.cs2430.test.utils;

public class Utils
{
    public static String nullSafeToString(Object object)
    {
        return (object == null) ? "null" : object.toString();
    }
}
