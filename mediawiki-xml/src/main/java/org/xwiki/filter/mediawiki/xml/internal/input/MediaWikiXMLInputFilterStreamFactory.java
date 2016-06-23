/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.filter.mediawiki.xml.internal.input;

import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.xml.stream.XMLEventWriter;

import org.xwiki.component.annotation.Component;
import org.xwiki.filter.mediawiki.input.MediaWikiXMLInputProperties;
import org.xwiki.filter.mediawiki.xml.internal.MediaWikiFilter;
import org.xwiki.filter.xml.internal.input.AbstractXMLBeanInputFilterStreamFactory;

import javanet.staxutils.XMLStreamEventWriter;

/**
 * Create MediaWiki XML format input filters.
 * 
 * @version $Id: 20ffe2c38296482590f986268a1b87f547beebae $
 */
@Component
@Named(MediaWikiXMLInputProperties.FILTER_STREAM_TYPE_STRING)
@Singleton
public class MediaWikiXMLInputFilterStreamFactory
    extends AbstractXMLBeanInputFilterStreamFactory<MediaWikiXMLInputProperties, MediaWikiFilter>
{
    private Provider<MediaWikiXMLStreamWriter> writerProvider;

    /**
     * The default constructor.
     */
    public MediaWikiXMLInputFilterStreamFactory()
    {
        super(MediaWikiXMLInputProperties.FILTER_STREAM_TYPE);

        setName("MediaWiki XML input stream");
        setDescription("Generates wiki events from MediaWiki XML package.");
    }

    @Override
    protected XMLEventWriter createXMLEventWriter(Object filter, MediaWikiXMLInputProperties parameters)
    {
        return new XMLStreamEventWriter(this.writerProvider.get());
    }
}
