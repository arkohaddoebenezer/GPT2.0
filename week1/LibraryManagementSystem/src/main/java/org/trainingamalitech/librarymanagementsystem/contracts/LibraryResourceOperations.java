package org.trainingamalitech.librarymanagementsystem.contracts;

import org.trainingamalitech.librarymanagementsystem.model.LibraryResource;

public interface LibraryResourceOperations {

    public  LibraryResource saveResource(LibraryResource libraryResource);

    public LibraryResource updateResource(LibraryResource libraryResource);

    public LibraryResource editResource(LibraryResource libraryResource);

    public void deleteResource(String resourceIdentifier);

    public void updateAvailability(LibraryResource libraryResource, boolean availability);
}
