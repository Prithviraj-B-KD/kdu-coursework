import os from "os";
import fs from "fs";
import http from "http";
import dotenv from "dotenv";
import path from "path";

dotenv.config();

//question 1 os method
//gets all os information using os module
function getSystemInfo() {
  const data = {
    hostname: os.hostname(),
    os: os.platform(),
    architecture: os.arch(),
    release: os.release(),
    uptime: Math.floor(os.uptime() / 60),
    numberOfCPUs: os.cpus().length,
    totalMemory: Math.floor(os.totalmem() / (1024 * 1024 * 1024)),
    freeMemory: Math.floor(os.freemem() / (1024 * 1024 * 1024)),
    cwd: process.cwd(),
  };

  return JSON.stringify(data, null, 2);
}

//writes the given input data to given file using fs module
function writeToFile(fileName, data) {
  try {
    fs.writeFileSync(fileName, data);
    console.log(`System info written to file: ${fileName}`);
  } catch (err) {
    console.error(`Error writing file: ${err}`);
  }
}

//creates server
function createServer(fileName) {
  const server = http.createServer((req, res) => {
    if (req.method === "GET" && req.url === "/") {
      try {
        const data = fs.readFileSync(fileName, "utf8");
        const systemInfo = JSON.parse(data);
        res.writeHead(200, { "Content-Type": "text/plain" });
        res.end(
          `Hello, my name is ${
            process.env.LOGNAME
          }! Here is my system:\n\n${JSON.stringify(systemInfo, null, 2)}`
        ); // Indented JSON in response
      } catch (err) {
        res.writeHead(500, { "Content-Type": "text/plain" });
        res.end(`Error loading system info: ${err}`);
      }
    } else {
      res.writeHead(404, { "Content-Type": "text/plain" });
      res.end("404 Not Found");
    }
  });

  return server;
}

//question 2 path
//extracts file info using path module
function extractFileInfo(filePath) {
  return {
    extension: path.extname(filePath),
    baseName: path.basename(filePath, path.extname(filePath)),
    directory: path.dirname(filePath),
  };
}

function processFilePaths(filePaths) {
  return filePaths.map(extractFileInfo);
}

const filePaths = [
  "dir1/dir2/file1.txt",
  "dir1/dir3/file2.txt",
  "dir1/dir3/file3.md",
  "dir4/file4.jpg",
  "dir4/file5.pdf",
];
const fileInfos = processFilePaths(filePaths);
console.log(fileInfos);

const fileName =
  "/Users/prithvirajb/kdu-coursework/frontend/homework/5/systemInfo.json";
const info = getSystemInfo();
writeToFile(fileName, info);

const server = createServer(fileName);
server.listen(3000, () => console.log(`Server listening on port 3000`));
