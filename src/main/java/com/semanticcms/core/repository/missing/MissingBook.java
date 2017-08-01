/*
 * semanticcms-core-repository-missing - Allows references to missing books with optional links to an external base URL.
 * Copyright (C) 2017  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of semanticcms-core-repository-missing.
 *
 * semanticcms-core-repository-missing is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * semanticcms-core-repository-missing is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with semanticcms-core-repository-missing.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.semanticcms.core.repository.missing;

import com.semanticcms.core.model.Author;
import com.semanticcms.core.model.BookRef;
import com.semanticcms.core.model.Copyright;
import com.semanticcms.core.model.PageRef;
import com.semanticcms.core.model.ParentRef;
import com.semanticcms.core.repository.Book;
import java.io.File;
import java.net.URL;
import java.util.Map;
import java.util.Set;

/**
 * A book that is missing and may not be access locally or remotely.
 */
public class MissingBook extends Book {

	private final String base;

	public MissingBook(BookRef bookRef, String canonicalBase, String base) {
		super(bookRef, canonicalBase);
		if(base != null) {
			while(base.endsWith("/")) {
				base = base.substring(0, base.length() - 1);
			}
		}
		this.base = base;
	}

	@Override
	public boolean isAccessible() {
		return false;
	}

	@Override
	public File getSourceFile(String path, boolean requireBook, boolean requireFile) {
		return null;
	}

	@Override
	public URL getSourceURL(String path) {
		return null;
	}

	@Override
	public Set<ParentRef> getParentRefs() {
		return null;
	}

	@Override
	public PageRef getContentRoot() {
		return null;
	}

	@Override
	public Copyright getCopyright() {
		return null;
	}

	@Override
	public Set<Author> getAuthors() {
		return null;
	}

	@Override
	public String getTitle() {
		return null;
	}

	@Override
	public boolean getAllowRobots() {
		return false;
	}

	@Override
	public Map<String,String> getParam() {
		return null;
	}

	/**
	 * Gets the base for this book, or {@code null} if not
	 * configured.
	 * <p>
	 * When no base is defined (is {@code null}), links to missing pages will be
	 * generated within the current webapp context.  Links within webapp context
	 * are response encoded.
	 * </p>
	 * <p>
	 * When the base is defined, any trailing slash (/) has been stripped from the base
	 * so can directly concatenate base + path.  Links to base are not response encoded,
	 * even when going to the same server or webapp context.
	 * </p>
	 * <p>
	 * This may be an empty string, which represents the server root.  Not to be
	 * confused with {@code null} which means no base defined.
	 * </p>
	 */
	public String getBase() {
		return base;
	}
}
