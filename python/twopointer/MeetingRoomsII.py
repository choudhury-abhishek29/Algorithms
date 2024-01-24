from typing import List


class MeetingRoomsII:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        start = sorted([i[0] for i in intervals])
        end = sorted([i[1] for i in intervals])
        maxRooms, count = 0, 0
        s, e = 0, 0

        while s < len(intervals):
            if start[s] < end[e]:
                s += 1
                count += 1
            else:
                e += 1
                count -= 1
            maxRooms = max(maxRooms, count)

        return maxRooms


mr = MeetingRoomsII()
print(mr.minMeetingRooms([[13,15],[1,13],[6,9]]))
