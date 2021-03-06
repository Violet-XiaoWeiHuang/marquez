/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package marquez.db.models;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.util.UUID;
import org.junit.Test;

public class JobRunArgsRowTest {
  private static final UUID ROW_UUID = UUID.randomUUID();
  private static final Instant CREATED_AT = Instant.now();
  private static final UUID JOB_RUN_UUID = UUID.randomUUID();
  private static final String RUN_ARGS = "{\"retries\": 1}";
  private static final Long CHECKSUM = 4546L;

  @Test
  public void testNewJobRow() {
    final JobRunArgsRow jobRunArgsRow =
        JobRunArgsRow.builder()
            .uuid(ROW_UUID)
            .createdAt(CREATED_AT)
            .jobRunUuid(JOB_RUN_UUID)
            .runArgs(RUN_ARGS)
            .checksum(CHECKSUM)
            .build();
    assertEquals(ROW_UUID, jobRunArgsRow.getUuid());
    assertEquals(CREATED_AT, jobRunArgsRow.getCreatedAt());
    assertEquals(JOB_RUN_UUID, jobRunArgsRow.getJobRunUuid());
    assertEquals(RUN_ARGS, jobRunArgsRow.getRunArgs());
    assertEquals(CHECKSUM, jobRunArgsRow.getChecksum());
  }

  @Test(expected = NullPointerException.class)
  public void testNewJobRow_nullUuid() {
    final UUID nullUuid = null;
    JobRunArgsRow.builder()
        .uuid(nullUuid)
        .createdAt(CREATED_AT)
        .jobRunUuid(JOB_RUN_UUID)
        .runArgs(RUN_ARGS)
        .checksum(CHECKSUM)
        .build();
  }

  @Test(expected = NullPointerException.class)
  public void testNewJobRow_nullCreatedAt() {
    final Instant nullCreatedAt = null;
    JobRunArgsRow.builder()
        .uuid(ROW_UUID)
        .createdAt(nullCreatedAt)
        .jobRunUuid(JOB_RUN_UUID)
        .runArgs(RUN_ARGS)
        .checksum(CHECKSUM)
        .build();
  }

  @Test(expected = NullPointerException.class)
  public void testNewJobRow_nullJobRunUuid() {
    final UUID nullJobRunUuid = null;
    JobRunArgsRow.builder()
        .uuid(ROW_UUID)
        .createdAt(CREATED_AT)
        .jobRunUuid(nullJobRunUuid)
        .runArgs(RUN_ARGS)
        .checksum(CHECKSUM)
        .build();
  }

  @Test(expected = NullPointerException.class)
  public void testNewJobRow_nullRunArgs() {
    final String nullRunArgs = null;
    JobRunArgsRow.builder()
        .uuid(ROW_UUID)
        .createdAt(CREATED_AT)
        .jobRunUuid(JOB_RUN_UUID)
        .runArgs(nullRunArgs)
        .checksum(CHECKSUM)
        .build();
  }

  @Test(expected = NullPointerException.class)
  public void testNewJobRow_nullChecksum() {
    final Long nullChecksum = null;
    JobRunArgsRow.builder()
        .uuid(ROW_UUID)
        .createdAt(CREATED_AT)
        .jobRunUuid(JOB_RUN_UUID)
        .runArgs(RUN_ARGS)
        .checksum(nullChecksum)
        .build();
  }
}
