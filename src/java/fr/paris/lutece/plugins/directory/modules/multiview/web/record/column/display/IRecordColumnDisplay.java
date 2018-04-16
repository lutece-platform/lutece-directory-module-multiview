/*
 * Copyright (c) 2002-2017, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.directory.modules.multiview.web.record.column.display;

import java.util.Locale;

import fr.paris.lutece.plugins.directory.modules.multiview.business.record.column.IRecordColumn;
import fr.paris.lutece.plugins.directory.modules.multiview.business.record.column.RecordColumnCell;
import fr.paris.lutece.plugins.directory.modules.multiview.web.record.util.IRecordListPosition;

/**
 * Interface for a RecordColumnDisplay objects
 */
public interface IRecordColumnDisplay extends IRecordListPosition
{
    /**
     * Return the header template of the RecordColumn
     * 
     * @return the header template of the RecordColumn
     */
    String getRecordColumnHeaderTemplate( );

    /**
     * Build the header template of the RecordColumn
     * 
     * @param strSortUrl
     *            The url used to sort the column
     * @param locale
     *            The locale to use to build the template
     * @return the record column header template
     */
    String buildRecordColumnHeaderTemplate( String strSortUrl, Locale locale );

    /**
     * Build the template of the RecordColumnCell
     * 
     * @param recordColumnCell
     *            The RecordColumnCell to use for build the template of the RecordColumnDisplay
     * @param locale
     *            The locale to use for build the template
     * @return the record column cell template
     */
    String buildRecordColumnCellTemplate( RecordColumnCell recordColumnCell, Locale locale );

    /**
     * Return the RecordColumn object associated to the RecordColumnDisplay
     * 
     * @return the RecordColumn object associated to the RecordColumnDisplay
     */
    IRecordColumn getRecordColumn( );

    /**
     * Set the RecordColumn of the RecordColumnDisplay
     * 
     * @param recordColumn
     *            The RecordColumn of the RecordColumnDisplay
     */
    void setRecordColumn( IRecordColumn recordColumn );
}