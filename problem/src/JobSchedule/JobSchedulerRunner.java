package JobSchedule;

public class JobSchedulerRunner {

    /*


    Entities
    Job
    id
    name
    Type
    Schedule
    command


    Schedule
    Interval
    dateTime

    Command


    API
    create job
    deactive job
    delete job
    update schedule
    update command


    Async process
    which fetch the job from schedule table and put into run table

    fetch from run table execute it.. can it happen paralle






    Scheduler  table
    Will insert into the table

   Million of jobs will there
   and we will be able to schedule them
   scanning the whole table is not feasible
    we can index the  interval data range

    we can get the jobs

    prepopulate the data in the table
    get the all the jobs run today..
    put into the Run table
    get all the jobs which has to run weekly and create today.
    get all the monthly which is created today.
    get all the yearly which is create today.

    query the table on the basis of hour and min
    and the job





    //get the all the jobs which has to run today ..







        Job
        schedule
        Runner command






     */

    public static void main(String[] args) {

    }
}
