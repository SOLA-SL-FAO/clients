/**
 * ******************************************************************************************
 * Copyright (C) 2012 - Food and Agriculture Organization of the United Nations (FAO).
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice,this list
 *       of conditions and the following disclaimer.
 *    2. Redistributions in binary form must reproduce the above copyright notice,this list
 *       of conditions and the following disclaimer in the documentation and/or other
 *       materials provided with the distribution.
 *    3. Neither the name of FAO nor the names of its contributors may be used to endorse or
 *       promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT
 * SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,PROCUREMENT
 * OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,STRICT LIABILITY,OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * *********************************************************************************************
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.clients.swing.gis.beans;

import java.util.ArrayList;
import java.util.List;
import org.sola.clients.beans.validation.ValidationResultBean;
import org.sola.common.MappingManager;
import org.sola.webservices.transferobjects.transaction.TransactionTO;

/**
 *
 * @author Elton Manoku
 */
public abstract class TransactionBean extends AbstractGisBean{
    
    private String fromServiceId;
    List<TransactionSourceBean> transactionSourceList = new ArrayList<TransactionSourceBean>();

    public String getFromServiceId() {
        return fromServiceId;
    }

    public void setFromServiceId(String fromServiceId) {
        this.fromServiceId = fromServiceId;
    }


    public List<TransactionSourceBean> getTransactionSourceList() {
        return transactionSourceList;
    }

    public void setTransactionSourceList(List<TransactionSourceBean> transactionSourceList) {
        this.transactionSourceList = transactionSourceList;
    }

        

    public List<String> getSourceIdList(){
        List<String> sourceIdList = new ArrayList<String>();
        for(TransactionSourceBean bean: this.getTransactionSourceList()){
            sourceIdList.add(bean.getSourceId());
        }
        return sourceIdList;
    }
    
    public void setSourceIdList(List<String> sourceIdList){
        this.transactionSourceList = new ArrayList<TransactionSourceBean>();
        for(String sourceId: sourceIdList){
            TransactionSourceBean bean = new TransactionSourceBean();
            bean.setSourceId(sourceId);
            this.transactionSourceList.add(bean);
        }
    }
    
    public abstract <T extends TransactionTO> T getTO();
    
    public abstract List<ValidationResultBean> save();
}
