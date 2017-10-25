# AndroidDateTime
https://stackoverflow.com/a/46923922/5381331

If we don't specific timezone when parse date. Calendar will use the timezone which have set in Setting
```
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.JAPAN);
```
Locale is the locale whose date format symbols should be used

