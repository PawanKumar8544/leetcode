class Solution {
    public List<String> removeSubfolders(String[] folders) {
        // Sort the array of folder paths to ensure that parent folders come before their subfolders.
        Arrays.sort(folders);

        // Initialize the answer list with the first folder path since it can not be a subfolder.
        List<String> filteredFolders = new ArrayList<>();
        filteredFolders.add(folders[0]);

        // Iterate through the sorted folder paths starting from the index 1.
        for (int i = 1; i < folders.length; ++i) {
            // Get the length of the last added folder path in the answer list.
            int lastAddedFolderPathLength = filteredFolders.get(filteredFolders.size() - 1).length();
          
            // Get the current folder path length.
            int currentFolderPathLength = folders[i].length();
          
            // Check if the last added folder is a prefix of the current folder and if there is a '/' right after it.
            // If the last added folder path is not a prefix of the current folder (or it is the complete current folder),
            // or the character just after the prefix is not '/', then it is not a subfolder.
            if (lastAddedFolderPathLength >= currentFolderPathLength
                || !(filteredFolders.get(filteredFolders.size() - 1).equals(folders[i].substring(0, lastAddedFolderPathLength))
                    && folders[i].charAt(lastAddedFolderPathLength) == '/')) {
                // If the current folder is not a subfolder, add it to the filtered list.
                filteredFolders.add(folders[i]);
            }
        }

        // Return the list of filtered folders with subfolders removed.
        return filteredFolders;
    }
}
