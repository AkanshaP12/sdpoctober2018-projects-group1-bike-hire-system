package edu.srh.bikehire.service.core;

import java.util.Calendar;

public interface Invoice {

    public String InvoiceId();
    
    public int OrderId();
    
    public Calendar CreationTimestamp();
    
    public int FinalAmount();
    
    public int ReturnAmount();
    
    public int DamagedCharges();
    
    public int WarehouseId();
    
}
