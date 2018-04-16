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
package fr.paris.lutece.plugins.directory.modules.multiview.business.record.filter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import fr.paris.lutece.test.LuteceTestCase;

/**
 * Test for the RecordFilterQueryBuilder
 */
public class RecordFilterQueryBuilderTest extends LuteceTestCase
{
    /**
     * {@inheritDoc}
     */
    @Override
    protected void setUp( ) throws Exception
    {
        super.setUp( );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void tearDown( ) throws Exception
    {
        super.tearDown( );
    }

    /**
     * Test of the method {@link RecordFilterQueryBuilder#buildRecordFilterQuery(String, RecordFilterItem)}
     */
    public void testBuildRecordFilterQueryWithDirectoryPattern( )
    {
        String strRecordFilterExpected = "directory.id_directory = 4";

        String strRecordFilterQueryPattern = "directory.id_directory = $id_directory$";

        Map<String, Object> mapFilterNameValues = new LinkedHashMap<>( );
        mapFilterNameValues.put( "id_directory", 4 );
        RecordFilterItem recordFilterItem = new RecordFilterItem( );
        recordFilterItem.setMapFilterNameValues( mapFilterNameValues );

        String strRecordFilterQuery = RecordFilterQueryBuilder.buildRecordFilterQuery( strRecordFilterQueryPattern, recordFilterItem );
        assertThat( strRecordFilterQuery, is( not( nullValue( ) ) ) );
        assertThat( strRecordFilterQuery, is( strRecordFilterExpected ) );
    }

    /**
     * Test of the method {@link RecordFilterQueryBuilder#buildRecordFilterQuery(String, RecordFilterItem)} with a null value
     */
    public void testBuildRecordFilterQueryWithNullValue( )
    {
        String strRecordFilterExpected = StringUtils.EMPTY;

        String strRecordFilterQueryPattern = "directory.id_directory = $id_directory$";

        Map<String, Object> mapFilterNameValues = new LinkedHashMap<>( );
        mapFilterNameValues.put( "id_directory", null );
        RecordFilterItem recordFilterItem = new RecordFilterItem( );
        recordFilterItem.setMapFilterNameValues( mapFilterNameValues );

        String strRecordFilterQuery = RecordFilterQueryBuilder.buildRecordFilterQuery( strRecordFilterQueryPattern, recordFilterItem );
        assertThat( strRecordFilterQuery, is( not( nullValue( ) ) ) );
        assertThat( strRecordFilterQuery, is( strRecordFilterExpected ) );
    }

    /**
     * Test of the method {@link RecordFilterQueryBuilder#buildRecordFilterQuery(String, RecordFilterItem)}
     */
    public void testBuildRecordFilterQueryWithWrongName( )
    {
        String strRecordFilterExpected = "directory.id_directory = $id_directory$";

        String strRecordFilterQueryPattern = "directory.id_directory = $id_directory$";

        Map<String, Object> mapFilterNameValues = new LinkedHashMap<>( );
        mapFilterNameValues.put( "test", 4 );
        RecordFilterItem recordFilterItem = new RecordFilterItem( );
        recordFilterItem.setMapFilterNameValues( mapFilterNameValues );

        String strRecordFilterQuery = RecordFilterQueryBuilder.buildRecordFilterQuery( strRecordFilterQueryPattern, recordFilterItem );
        assertThat( strRecordFilterQuery, is( not( nullValue( ) ) ) );
        assertThat( strRecordFilterQuery, is( strRecordFilterExpected ) );
    }

    /**
     * Test of the method {@link RecordFilterQueryBuilder#buildRecordFilterQuery(String, RecordFilterItem)} with a query pattern with multiple names
     */
    public void testBuildRecordFilterQueryWithMultipleName( )
    {
        String strRecordFilterExpected = "directory.id_directory = 4 AND workflow_state.id_workflow_state = 42";

        String strRecordFilterQueryPattern = "directory.id_directory = $id_directory$ " + "AND workflow_state.id_workflow_state = $id_workflow_state$";

        Map<String, Object> mapFilterNameValues = new LinkedHashMap<>( );
        mapFilterNameValues.put( "id_directory", 4 );
        mapFilterNameValues.put( "id_workflow_state", 42 );
        RecordFilterItem recordFilterItem = new RecordFilterItem( );
        recordFilterItem.setMapFilterNameValues( mapFilterNameValues );

        String strRecordFilterQuery = RecordFilterQueryBuilder.buildRecordFilterQuery( strRecordFilterQueryPattern, recordFilterItem );
        assertThat( strRecordFilterQuery, is( not( nullValue( ) ) ) );
        assertThat( strRecordFilterQuery, is( strRecordFilterExpected ) );
    }

    /**
     * Test of the method {@link RecordFilterQueryBuilder#buildRecordFilterQuery(String, RecordFilterItem)} with a query pattern with multiple values to replace
     * and a null value
     */
    public void testBuildRecordFilterQueryWithMultipleNameWithWrongValue( )
    {
        String strRecordFilterExpected = StringUtils.EMPTY;

        String strRecordFilterQueryPattern = "directory.id_directory = $id_directory$ " + "AND workflow_state.id_workflow_state = $id_workflow_state$";

        Map<String, Object> mapFilterNameValues = new LinkedHashMap<>( );
        mapFilterNameValues.put( "id_directory", 4 );
        mapFilterNameValues.put( "id_workflow_state", null );
        RecordFilterItem recordFilterItem = new RecordFilterItem( );
        recordFilterItem.setMapFilterNameValues( mapFilterNameValues );

        String strRecordFilterQuery = RecordFilterQueryBuilder.buildRecordFilterQuery( strRecordFilterQueryPattern, recordFilterItem );
        assertThat( strRecordFilterQuery, is( not( nullValue( ) ) ) );
        assertThat( strRecordFilterQuery, is( strRecordFilterExpected ) );
    }

    /**
     * Test of the method {@link RecordFilterQueryBuilder#buildRecordFilterQuery(String, RecordFilterItem)} with a query pattern with nothing to replace but
     * with element which has the same name that those in the map parameter
     */
    public void testBuildRecordFilterQueryWithoutElementToReplace( )
    {
        String strRecordFilterExpected = "directory.id_directory = id_directory";

        String strRecordFilterQueryPattern = "directory.id_directory = id_directory";

        Map<String, Object> mapFilterNameValues = new LinkedHashMap<>( );
        mapFilterNameValues.put( "id_directory", 4 );
        RecordFilterItem recordFilterItem = new RecordFilterItem( );
        recordFilterItem.setMapFilterNameValues( mapFilterNameValues );

        String strRecordFilterQuery = RecordFilterQueryBuilder.buildRecordFilterQuery( strRecordFilterQueryPattern, recordFilterItem );
        assertThat( strRecordFilterQuery, is( not( nullValue( ) ) ) );
        assertThat( strRecordFilterQuery, is( strRecordFilterExpected ) );
    }
}