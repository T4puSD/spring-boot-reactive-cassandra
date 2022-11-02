package com.tapusd.reactivecassandra.domain;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Map;
import java.util.UUID;

@Table("course")
public class Course {

    @PrimaryKeyColumn(name = "course_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID courseId;

    @Column(isStatic = true)
    @CassandraType(type = CassandraType.Name.TEXT)
    private String name;

    @PrimaryKeyColumn(name = "module_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID moduleId;

    @Column("module_name")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String moduleName;

    @CassandraType(type = CassandraType.Name.MAP, typeArguments = {CassandraType.Name.UUID, CassandraType.Name.TEXT})
    private Map<UUID, String> authors;

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getModuleId() {
        return moduleId;
    }

    public void setModuleId(UUID moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Map<UUID, String> getAuthors() {
        return authors;
    }

    public void setAuthors(Map<UUID, String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                ", moduleId='" + moduleId + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", authors=" + authors +
                '}';
    }
}
