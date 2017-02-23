package users;

/**
 * Created by rjara on 2/22/2017.
 */

public class Manager extends Worker {
    /**
     *
     * @return true if the Historical Report was submitted
     */
    public boolean viewHistoricalReport() {
        return true;
    }

    /**
     *
     * @return true if a report has been deleted.
     */
    public boolean deleteReport() {
        return true;
    }
}
