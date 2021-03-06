/*
 * Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.springframework.security.userdetails.ldap;

import java.util.Collections;

import org.springframework.security.core.userdetails.*;

import junit.framework.TestCase;

/**
 * Tests for UsernameFromPropertyAccountMapper.
 *
 * @author Valery Tydykov
 *
 */
public class UsernameFromPropertyAccountMapperTest extends TestCase {

    UsernameFromPropertyAccountMapper mapper;

    @Override
    protected void setUp() throws Exception {
        this.mapper = new UsernameFromPropertyAccountMapper();
    }

    /**
     * Test method for
     * {@link org.springframework.security.userdetails.ldap.UsernameFromPropertyAccountMapper#map(org.springframework.security.userdetails.UserDetails)}
     * .
     */
    public final void testNormalOperation() {
        final String usernameExpected = "username1";
        final UserDetails user = new User(usernameExpected, "password1", Collections.EMPTY_SET);
        this.mapper.setUsername(usernameExpected);
        final String username = this.mapper.map(user);

        assertEquals(usernameExpected, username);
    }

    /**
     * Test method for
     * {@link org.springframework.security.userdetails.ldap.UsernameFromPropertyAccountMapper#afterPropertiesSet()}
     * .
     */
    public final void testAfterPropertiesSet() {
        try {
            this.mapper.afterPropertiesSet();
            fail("expected exception");
        } catch (final IllegalArgumentException expected) {
        } catch (final Exception unexpected) {
            fail("unexpected exception");
        }
    }
}
