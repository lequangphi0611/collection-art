package com.collectionart.app.collectionart.auth;

import java.util.Collection;

public interface Authorized {

    <A extends Authority> Collection<A> getAuthorities();

}
