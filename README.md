Reserve Theater Seats<br/>

Implement a reservation system for movie theaters that automatically 
places users in the most desirable seats available for their party.<br/>

The user will interact with the system on the command line. The system will prompt the user 
with the phrase, “What would you like to do?”, and the user can enter: <br/>
●  “reserve <number>” to reserve that number of seats; <br/>
●  “show” to display the current available seating in the theater; <br/>
●  “done” to shut down the system. <br/>
<br/>
When a user requests to reserve some number of seats, the system automatically finds the best 
seats  in  the  theater  that  share  a  single  row.  The  “best  seats”  are  assumed  to  be  in  the  rows 
nearest the middle of the theater (not too close, not too far). If no rows contain a sufficient number 
of unreserved seats, the system will apologize and decline to make a reservation<br/>

<br/>
A few points to consider: <br/>
●  Best seats are filled first-come / first-serve, provided there are enough empty seats in a 
row to accommodate a party.  <br/>
●  Best  seats  are  determined  by  proximity  to  the  center  row.  A  seat  N  rows  ahead  of  the 
center row is regarded as approximately equivalent to a seat N rows behind the center 
row. The front row and the back row (in either order) should be the last two rows assigned. <br/>
●  Left / right / center priority need not be considered. Rows can fill up from left to right or 
vice versa, or from the center, as long as parties are not separated. <br/>
●  No party is separated by the system across multiple rows. The number of seats in a single 
reservation must all be together on the same row, or the reservation will not be made. <br/>

<br/>
If and only if all other rows are occupied, then the system will reserve seats in accessible rows 
to users who do not need accessible seats. <br/>
 
The “show” command should indicate which rows are wheelchair-accessible. Whereas seats in 
rows that are not accessible are represented by “_”, seats in rows that are wheelchair-
accessible should be represented by “=”. <br/>