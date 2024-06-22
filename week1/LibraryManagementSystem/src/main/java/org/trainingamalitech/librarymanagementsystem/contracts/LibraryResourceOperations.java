package org.trainingamalitech.librarymanagementsystem.contracts;

import org.trainingamalitech.librarymanagementsystem.model.LibraryResource;

public interface LibraryResourceOperation {

    public  LibraryResource saveResource();

    public LibraryResource updateResource();

    public LibraryResource editResource();

    public LibraryResource deleteResource();


}
