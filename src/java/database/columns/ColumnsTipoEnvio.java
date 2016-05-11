/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.columns;

import static database.columns.ColumnsEnvio.valueOf;

/**
 *
 * @author Sergio
 */
public enum ColumnsTipoEnvio {
    TIPO,
    VALOR;
    public ColumnsTipoEnvio fromString(String param) {
        String toUpper = param.toUpperCase();
        try {
            return valueOf(toUpper);
        } catch (Exception e) {
            return null;
        }
    }
}
