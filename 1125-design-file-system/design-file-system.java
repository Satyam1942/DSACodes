class FileSystem {
    HashMap<String, Integer> map;

    public FileSystem() {
        map = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        if (map.containsKey(path))
            return false;

        StringBuilder temp = new StringBuilder();
        temp.append("/");
        for (int idx = 1; idx < path.length(); idx++) {
            char token = path.charAt(idx);
            if (token == '/') {
                String check = temp.toString();
                if (!map.containsKey(check))
                    return false;

            }
            temp.append(token);
        }
          map.put(path, value);
        return true;
    }

    public int get(String path) {
        if (!map.containsKey(path))
            return -1;
        else
            return (int)map.get(path);

    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */