/*
 Navicat Premium Data Transfer

 Source Server         : oracle11g
 Source Server Type    : Oracle
 Source Server Version : 110200
 Source Host           : localhost:1521
 Source Schema         : SCOTT

 Target Server Type    : Oracle
 Target Server Version : 110200
 File Encoding         : 65001

 Date: 08/06/2023 19:34:42
*/


-- ----------------------------
-- Table structure for visitcount
-- ----------------------------
DROP TABLE "SCOTT"."visitcount";
CREATE TABLE "SCOTT"."visitcount" (
  "times" NUMBER
)
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of visitcount
-- ----------------------------
INSERT INTO "SCOTT"."visitcount" VALUES ('19');
