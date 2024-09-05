
package com.system.identity;

/**
 *
 * @author llagu
 */
public class Unidad_medida {
    private int id;
    private String unidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    @Override
    public String toString() {
        return this.unidad;
    }
    
}
