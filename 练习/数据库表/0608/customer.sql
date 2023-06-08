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

 Date: 08/06/2023 19:33:56
*/


-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE "SCOTT"."customer";
CREATE TABLE "SCOTT"."customer" (
  "id" NUMBER NOT NULL,
  "cname" VARCHAR2(255 BYTE),
  "cpwd" VARCHAR2(255 BYTE),
  "cage" VARCHAR2(255 BYTE)
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
-- Records of customer
-- ----------------------------
INSERT INTO "SCOTT"."customer" VALUES ('1', 'tyza66', 'tyza66', '96');
INSERT INTO "SCOTT"."customer" VALUES ('5', 'csc', 'czss', 'cs ');
INSERT INTO "SCOTT"."customer" VALUES ('2', 'admin', 'admin', '96');

-- ----------------------------
-- Primary Key structure for table customer
-- ----------------------------
ALTER TABLE "SCOTT"."customer" ADD CONSTRAINT "SYS_C0011087" PRIMARY KEY ("id");
