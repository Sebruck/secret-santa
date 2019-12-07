# Secret Santa

A simple algorithm to draw for [Secret Santa](https://en.wikipedia.org/wiki/Secret_Santa).

It supports blacklisting so some attendees can't draw specific other atteedees. We used that to 
avoid couples drawing their partners since they get a present anyways.

The results are written as files to the `./results` directory, for each attendee exists one file,
it contains the name of the person who gets the gift. These files can then be distributed via email. 
