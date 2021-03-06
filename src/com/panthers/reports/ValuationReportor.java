package com.panthers.reports;

import com.panthers.orders.Transaction;
import com.panthers.services.InventoryManager;
import com.panthers.store.Store;
import com.panthers.utilities.Money;
import com.panthers.utilities.Date;
import java.util.*;

/**
 * @author Wei Chung Huang
 */
public class ValuationReportor extends Report implements IReport {

	private static ValuationReportor instance = null;
	
	public static ValuationReportor getInstance() {
		if (instance == null) {
			instance = new ValuationReportor();
		}
		return instance;
	}

    /**
     * @param UPC 
     * @param start 
     * @param end 
     * @return
     */
    public Money getAveragePrice(String UPC, Date start, Date end) {
            // dbInventory: let's assume we have a db to store price by using KEY: UPC
            int durationInDays = com.panthers.utilities.Date.getDurationInDays(start, end);
            int totalAmount = 0;
            for (int i = 0; i < durationInDays; i++) {
                com.panthers.utilities.Date newDate = com.panthers.utilities.Date.addDateByNumberOfDays(start, i);
                // Money newPrice = dbInventory.queryPrice(newDate);
                // ----fake one----
                Money newPrice = new Money(1);
                totalAmount += newPrice.getAmount();
                // ----------------
            }
            
            return new Money(totalAmount);
    }

    /**
     * @return
     */
    public Money getWarehouseValue() {
            InventoryManager ISM = InventoryManager.getInstance();
            // dbInventory: let's assume we have a db to store all stores by using KEY: UPC
            // Set<Store> allStores; = dbInventory.pullAllStores();
            // ----fake one----
            List<Store> allStores = null;
            int totalAmount = 0;
            for (int i = 0; i < allStores.size(); i++) {
                Store s = allStores.get(i);
                // Quantity quantity = s.getProductQuantity()
                // Money price = s.getProduct().getUnitPrice();
                // totalAmount += quantity.getAmount() * price.getAmount();
            }
            // ----------------
            return new Money(totalAmount);
    }

    /**
     * @param start Date 
     * @param end Date 
     * @return
     */
    public List<Transaction> getSalesActivity(Date start, Date end) {
            // dbInventory: let's assume we have a db to store all stores by using KEY: UPC
            // ----fake one----
            int durationInDays = Date.getDurationInDays(start, end);
            
            ArrayList<Transaction> allTrans = null;
            for (int i = 0; i < durationInDays; i++) {
                com.panthers.utilities.Date newDate = com.panthers.utilities.Date.addDateByNumberOfDays(start, i);
                // Transaction trans = dbInventory.queryTransaction(newDate);
                Transaction trans = null;
                allTrans.add(trans);
            }
            // ----------------            
            return allTrans;
    }
    
    /**
     * @param filePath
     */
    @Override
    public void saveReportAsPDF(String filePath) {
            // TODO Auto-generated method stub
            // Bascially, this area should generate PDF with layout of every records.
            // Then save file to given path
    }
    
    /**
     * 
     */
    @Override
    public void printReport() {
            // TODO Auto-generated method stub
            // Deal with UI to display records        
    }    
}