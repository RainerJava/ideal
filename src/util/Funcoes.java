/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Tiago
 */
public class Funcoes {

    public Funcoes() {
    }

    public Date transformarStringEmData(String data) {
        if (data == null || data.equals("")) {
            return null;
        }

        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (java.util.Date) formatter.parse(data);
        } catch (ParseException e) {
        }
        return date;
    }

    public java.sql.Date convertFromJAVADateToSQLDate(java.util.Date javaDate) {
        java.sql.Date sqlDate = null;
        if (javaDate != null) {
            sqlDate = new java.sql.Date (javaDate.getTime());
        }
        return sqlDate;
    }

    public String translatePromo(int promo) {
        String ret = "";
        switch (promo) {

            case 1:
                ret = "Descontos";
                break;

            case 2:
                ret = "Junte e Ganhe";
                break;
            case 3:
                ret = "Pague 1 Leve 2";
                break;
            case 4:
                ret = "Combos";
                break;
        }

        return ret;
    }
}
