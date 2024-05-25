/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 
 */
public class modeltabelhewan extends AbstractTableModel {
    List<datahewan> dh;
    public modeltabelhewan(List<datahewan>dh){
        this.dh = dh;
    }
    
    @Override
    public int getRowCount() {
        return dh.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "id";
            case 1:
                return "nama_pemilik";
            case 2:
                return "nama_hewan";
            case 3:
                return "jenis_hewan";
            case 4:
                return "nomor_telepon";
            case 5:
                return "durasi_titip";
            case 6:
                return "total_biaya";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dh.get(row).getId();
            case 1:
                return dh.get(row).getNama_pemilik();
            case 2:
                return dh.get(row).getNama_hewan();
            case 3:
                return dh.get(row).getJenis_hewan();
            case 4:
                return dh.get(row).getNomor_telepon();
            case 5:
                return dh.get(row).getDurasi_titip();
            case 6:
                return dh.get(row).getTotal_biaya();
                
            default:
                return null;
        }
    }
}
