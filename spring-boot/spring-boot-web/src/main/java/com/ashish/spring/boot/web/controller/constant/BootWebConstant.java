package com.ashish.spring.boot.web.controller.constant;

public final class BootWebConstant {

    public static final String BOOT_CONSUMER_API="/consumer";
    public static final String BOOT_PRODUCER_API="/producer";
    public static final String JAVA_8_FEATURES="/java8features";

    public static final String FILTER_EMP_NAME_START_URL=BOOT_CONSUMER_API+JAVA_8_FEATURES+"/invoke/empbyname";
    public static final String FILTER_EMP_BY_GROUP_URL=BOOT_CONSUMER_API+JAVA_8_FEATURES+"/invoke/empbygroup";

    public static final String GET_AVAILABLE_DELETE_APIS=BOOT_CONSUMER_API+"/invoke/delete/available/apis";

    public static final String GET_DELETE_SINGLE_RECORD=BOOT_CONSUMER_API+"/invoke/delete/single/record";
    public static final String GET_DELETE_MULTIPLE_RECORD=BOOT_CONSUMER_API+"/invoke/delete/multiple/record";

    public static final String GET_COMPARE_REPO_FILES=BOOT_CONSUMER_API+"/invoke/repo/file/compare";

    public static final String GET_DUPLICATE_KEYS_IN_PROP_FILE=BOOT_CONSUMER_API+"/invoke/repo/file/duplicate/key";
}
