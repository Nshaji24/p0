package com.dealership.util;
import com.dealership.model.User;

public abstract class dealershipList extends dealershipCollection{
    public abstract void order();

    public abstract int indexOf(User u);
}
