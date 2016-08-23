/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agoncal.book.javaee7.chapter09.ex07;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

/**
 *
 * @author patrik
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class InventoryServiceGateway {
    @Inject
    InventoryService07 service;

    public void addItem(Item07 item) {
        service.addItem(item);
    }
    
}
