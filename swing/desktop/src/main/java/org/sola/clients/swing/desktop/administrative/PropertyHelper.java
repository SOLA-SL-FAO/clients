/**
 * ******************************************************************************************
 * Copyright (C) 2015 - Food and Agriculture Organization of the United Nations (FAO).
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
package org.sola.clients.swing.desktop.administrative;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.JDialog;
import org.sola.clients.beans.administrative.BaUnitBean;
import org.sola.clients.beans.administrative.RrrBean;
import org.sola.clients.beans.application.ApplicationBean;
import org.sola.clients.beans.application.ApplicationPropertyBean;
import org.sola.clients.beans.application.ApplicationServiceBean;
import org.sola.clients.beans.referencedata.BaUnitTypeBean;
import org.sola.clients.beans.referencedata.RequestTypeBean;
import org.sola.clients.beans.referencedata.StatusConstants;
import org.sola.clients.swing.desktop.application.PropertiesList;
import org.sola.clients.swing.ui.ContentPanel;
import org.sola.common.WindowUtility;
import org.sola.common.messaging.ClientMessage;
import org.sola.common.messaging.MessageUtility;

/**
 * Class providing utility methods related to managing property records.
 *
 * @author soladev
 */
public class PropertyHelper {

    private static ApplicationPropertyBean appProperty;

    /**
     * Obtains the BaUnitBean to use for a service based on the details in the
     * Application Property.
     *
     * @param appBean The ApplicationBean representing the application
     * @param appService The Service to retrieve the BaUnitBean for (where the
     * service has already been started).
     * @param window The parent window for this method. Used to anchor any
     * dialog box that may need to be displayed
     * @param isNewPropertyService Flag to indicate if the property is a new
     * property service or not.
     * @return The BaUnitBean for the service
     */
    public static BaUnitBean getBaUnitBeanForService(ApplicationBean appBean,
            ApplicationServiceBean appService, ContentPanel window, boolean isNewPropertyService) {

        if (appBean == null || appService == null) {
            return null;
        }

        BaUnitBean result = null;
        appProperty = null;
        List<BaUnitBean> baUnitList = BaUnitBean.getBaUnitsByServiceId(appService.getId());
        if (baUnitList != null && baUnitList.size() == 1) {
            // Serivce has previously linked to an BA Unit, so return that property for the service
            result = baUnitList.get(0);
        } else if (isNewPropertyService) {
            result = prepareNewStateLand(appBean, appService.getRequestType());
        } else {
            // Determine the property to use for this service based on the list of application properties
            if (appBean.getPropertyList().getFilteredList().size() == 1) {
                appProperty = appBean.getPropertyList().getFilteredList().get(0);
            } else if (appBean.getPropertyList().getFilteredList().size() > 1) {
                // Prompt the user to indicate which property record is required. 
                PropertiesList propertyListForm = new PropertiesList(appBean.getPropertyList());
                propertyListForm.setLocationRelativeTo(window);

                propertyListForm.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if (evt.getPropertyName().equals(PropertiesList.SELECTED_PROPERTY)
                                && evt.getNewValue() != null) {
                            appProperty = (ApplicationPropertyBean) evt.getNewValue();
                            ((JDialog) evt.getSource()).dispose();
                        }
                    }
                });
                WindowUtility.addEscapeListener(propertyListForm, false);
                propertyListForm.setVisible(true);
            } else {
                MessageUtility.displayMessage(ClientMessage.APPLICATION_NO_PROPERTY_FOR_SERVICE);
            }

            if (appProperty != null) {
                if (appProperty.getBaUnitId() != null) {
                    result = BaUnitBean.getBaUnitsById(appProperty.getBaUnitId());
                } else {
                    // Create a default property record using the name details specified for the
                    // Application Property
                    result = new BaUnitBean();
                    result.setNameFirstpart(appProperty.getNameFirstpart());
                    result.setNameLastpart(appProperty.getNameLastpart());
                }
            }
        }
        return result;
    }

    /**
     * Creates a new State Land property record and creates a default State Land
     * Ownership RRR that must be completed by the user.
     *
     * @param appBean
     * @param requestType
     * @return
     */
    private static BaUnitBean prepareNewStateLand(ApplicationBean appBean,
            RequestTypeBean requestType) {
        BaUnitBean result = new BaUnitBean();
        result.setTypeCode(BaUnitTypeBean.CODE_STATE_LAND);
        result.setStatusCode(StatusConstants.PENDING);

        RrrBean ownerRrr = new RrrBean();
        ownerRrr.setTypeCode(RrrBean.CODE_STATE_OWNERSHIP);
        ownerRrr.setPrimary(true);
        ownerRrr.setStatusCode(StatusConstants.PENDING);
        ownerRrr.getNotation().setNotationText(requestType.getNotationTemplate());

        result.addRrr(ownerRrr);

        return result;
    }
}
