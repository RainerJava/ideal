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
import org.eclipse.persistence.expressions.ExpressionOperator;

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
            sqlDate = (java.sql.Date) new Date(javaDate.getTime());
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
                ret = "Pague 1 leve 2";
                break;
            case 3:
                ret = "Junte e ganhe";
                break;
            case 4:
                ret = "Combos";
                break;
        }

        return ret;
    }
}
