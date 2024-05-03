class Solution {
    String[] split(String v, char parameter) {
        int length = v.length();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char token = v.charAt(i);
            if (token == parameter) {
                list.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(token);
            }
        }

        list.add(sb.toString());

        String arr[] = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int compareVersion(String version1, String version2) {
        String revisionVersion1[] = split(version1, '.');
        String revisionVersion2[] = split(version2, '.');

        int noOfRevisions = Math.max(revisionVersion1.length, revisionVersion2.length);

        for (int i = 0; i < noOfRevisions; i++) {

            int rev1 = (i < revisionVersion1.length) ? Integer.valueOf(revisionVersion1[i]) : 0;
            int rev2 = (i < revisionVersion2.length) ? Integer.valueOf(revisionVersion2[i]) : 0;

            if (rev1 == rev2)
                continue;
            else if (rev1 > rev2)
                return 1;
            else
                return -1;
        }

        return 0;

    }
}