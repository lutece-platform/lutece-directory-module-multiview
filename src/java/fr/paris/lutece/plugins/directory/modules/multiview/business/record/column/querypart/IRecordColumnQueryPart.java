/*
 * Copyright (c) 2002-2018, Mairie de Paris
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
package fr.paris.lutece.plugins.directory.modules.multiview.business.record.column.querypart;

import java.util.List;

import fr.paris.lutece.plugins.directory.modules.multiview.business.record.column.IRecordColumn;
import fr.paris.lutece.plugins.directory.modules.multiview.business.record.column.RecordColumnCell;
import fr.paris.lutece.util.sql.DAOUtil;

/**
 * Global interface for all record column query part
 */
public interface IRecordColumnQueryPart
{
    /**
     * Return the select query part for the RecordColumn
     * 
     * @return the select query part for the RecordColumn
     */
    String getRecordColumnSelectQuery( );

    /**
     * Return the from query part for the RecordColumn
     * 
     * @return the from query part for the RecordColumn
     */
    String getRecordColumnFromQuery( );

    /**
     * Return the list of join queries for the RecordColumn
     * 
     * @return the list of join queries for the RecordColumn
     */
    List<String> getRecordColumnJoinQueries( );

    /**
     * Set the record column to the RecordColumnQueryPart
     * 
     * @param recordColumn
     *            The RecordColumn to set to the RecordColumnQueryPart
     */
    void setRecordColumn( IRecordColumn recordColumn );

    /**
     * Return the RecordColumn of the RecordColumnQueryPart
     * 
     * @return the RecordColumn of the RecordColumnQueryPart
     */
    IRecordColumn getRecordColumn( );

    /**
     * Return the RecordColumnCell of the RecordColumnQueryPart
     * 
     * @param daoUtil
     *            The daoUtil to retrieve the values to retrieve to the record column
     * @return the RecordColumnCell which contains all the values of the record column from the given daoUtil
     */
    RecordColumnCell getRecordColumnCell( DAOUtil daoUtil );
}
