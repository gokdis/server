package eu.ecosys.gokdis.server.entity;

import java.util.List;

public record PageResponse<T>(List<T> content, String pagingState) {
};