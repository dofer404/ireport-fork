/*
 * iReport - Visual Designer for JasperReports.
 * Copyright (C) 2002 - 2009 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of iReport.
 *
 * iReport is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * iReport is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with iReport. If not, see <http://www.gnu.org/licenses/>.
 */
package com.jaspersoft.ireport.designer.sheet.properties.charts;

import com.jaspersoft.ireport.designer.sheet.properties.FloatProperty;
import com.jaspersoft.ireport.locale.I18n;
import net.sf.jasperreports.engine.base.JRBaseChartPlot;
    
    
/**
 *  Class to manage the JRBaseChartPlot.PROPERTY_FOREGROUND_ALPHA property
 */
public final class PlotForegroundAlphaProperty extends FloatProperty {

    private final JRBaseChartPlot plot;

    
    public PlotForegroundAlphaProperty(JRBaseChartPlot plot)
    {
        super(plot);
        this.plot = plot;
    }

    @Override
    public String getName()
    {
        return JRBaseChartPlot.PROPERTY_FOREGROUND_ALPHA;
    }

    @Override
    public String getDisplayName()
    {
        return I18n.getString("Foreground_Alpha_(%)");
    }

    @Override
    public String getShortDescription()
    {
        return I18n.getString("Foreground_Alpha.");
    }

    @Override
    public Float getFloat()
    {
        return plot.getForegroundAlphaFloat();
    }

    @Override
    public Float getOwnFloat()
    {
        return plot.getForegroundAlphaFloat();
    }

    @Override
    public Float getDefaultFloat()
    {
        return null;
    }

    @Override
    public void setFloat(Float foregroundAlpha)
    {
        plot.setForegroundAlpha(foregroundAlpha);
    }

    @Override
    public void validateFloat(Float foregroundAlpha)
    {
        if (foregroundAlpha != null && (foregroundAlpha < 0f || foregroundAlpha > 1f))
        {
            throw annotateException(I18n.getString("The_value_must_be_between_0_and_1."));
        }
    }

}
