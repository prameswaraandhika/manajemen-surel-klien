package com.prameswaradev.manajemensurelklien.model.table;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;

public class AbstractTableItem {

    private final SimpleBooleanProperty read = new SimpleBooleanProperty();

    public AbstractTableItem(boolean isRead) {
        this.setRead(isRead);
    }

    public boolean isRead() {
        return read.get();
    }

    public SimpleBooleanProperty readProperty() {
        return read;
    }

    public void setRead(boolean read) {
        this.read.set(read);
    }

    public SimpleBooleanProperty getReadProperty(){
        return read;
    }
}
