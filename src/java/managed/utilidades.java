/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Marcelo
 */
public class utilidades {
    private Date myDate;

    public Date getMyDate() {
        return myDate;
    }

    public String getMyFormattedDate() {
        return new SimpleDateFormat("dd-MM-yyyy").format(myDate);
    }
}
