class Solution {
    public int compareVersion(String version1, String version2) {
        String revisionVersion1[] = version1.split("\\.");
        String revisionVersion2[] = version2.split("\\.");
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