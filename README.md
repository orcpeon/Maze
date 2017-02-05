# Maze
Test task for SoftClub


The way it works is the maze is read from tha input file and consists of Point objects, which all have x, y coordinates and boolean variable, that determines if the Point is passable or not. Wall are unpassable, dead end are marked as unpassable in the process. Every turn is recorded to the path string.
Upon finishing, the path string is recorded to the storage and the whole cycles starts again. Wi th dead ends marked unpassasble the path should be different.
After every cycle recorded path is compared with every path in the storage. If it equals one of the storaged - the cycles stop and the shortest path is chosen.

It reads the maze from the root directory of the projects and writes the output to the same location.
