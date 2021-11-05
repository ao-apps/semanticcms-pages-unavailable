/*
 * semanticcms-pages-unavailable - Unavailable sets of SemanticCMS pages.
 * Copyright (C) 2017, 2018, 2021  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of semanticcms-pages-unavailable.
 *
 * semanticcms-pages-unavailable is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * semanticcms-pages-unavailable is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with semanticcms-pages-unavailable.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.semanticcms.pages.unavailable;

import com.aoapps.net.Path;
import com.semanticcms.core.model.Page;
import com.semanticcms.core.pages.CaptureLevel;
import com.semanticcms.core.pages.PageRepository;
import java.io.IOException;

/**
 * A permanently unavailable {@link PageRepository}
 */
public final class UnavailablePageRepository implements PageRepository {

	private static final UnavailablePageRepository instance = new UnavailablePageRepository();

	public static UnavailablePageRepository getInstance() {
		return instance;
	}

	private UnavailablePageRepository() {
		// Do nothing
	}

	@Override
	public String toString() {
		return "unavailable:";
	}

	@Override
	public boolean isAvailable() {
		return false;
	}

	@Override
	public Page getPage(Path path, CaptureLevel captureLevel) throws IOException {
		throw new IOException("Page repository is unavailable: " + path);
	}
}
