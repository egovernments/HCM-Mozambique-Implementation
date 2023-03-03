CREATE TABLE eg_dhis2_record(
                    dhis2RecordInternalId bigint,
                    dhis2Id character varying(64),
                    dhis2EntityType character varying(64),
                    dhis2DataPayload json,
                    source character varying(64),
                    createdBy character varying(64),
                    lastModifiedBy character varying(64),
                    createdTime timestamp,
                    lastModifiedTime timestamp,
                    CONSTRAINT uk_eg_dhis2_record PRIMARY KEY (dhis2RecordInternalId)
);
CREATE TABLE eg_digit_mapping(
                    digitMappingId bigint,
                    dhis2RecordInternalId bigint,
                    digitId character varying(64),
                    digitEntityType character varying(64),
                    createdBy character varying(64),
                    lastModifiedBy character varying(64),
                    createdTime timestamp,
                    lastModifiedTime timestamp,
                    CONSTRAINT uk_eg_digit_mapping PRIMARY KEY (digitMappingId)
);
CREATE TABLE eg_scheduler_job_history(
                    jobID character varying(64),
                    jobType character varying(64),
                    jobName character varying(128),
                    executionStartTime timestamp,
                    executionCompletionTime timestamp,
                    status character varying(10),
                    executionRetryCount bigint,
                    createdBy character varying(64),
                    lastModifiedBy character varying(64),
                    createdTime timestamp,
                    lastModifiedTime timestamp,
                    CONSTRAINT uk_eg_scheduler_job_history PRIMARY KEY (jobId)
);
CREATE TABLE eg_hcm_event_history(
                    eventId character varying(64),
                    jobId character varying(64),
                    url character varying(64),
                    payload json,
                    status bigint,
                    message character varying(64),
                    createdBy character varying(64),
                    lastModifiedBy character varying(64),
                    createdTime timestamp,
                    lastModifiedTime timestamp,
                    CONSTRAINT uk_eg_hcm_event_history PRIMARY KEY (eventId)
);