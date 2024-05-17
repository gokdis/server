package eu.ecosys.gokdis.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.ecosys.gokdis.server.entity.Cell;
import eu.ecosys.gokdis.server.repository.CellRepository;

@Service
public class CellService {
    @Autowired
    private CellRepository cellRepository;

    public Iterable<Cell> findAll() {
        return cellRepository.findAll();
    }

    public Cell findByXAndY(int x, int y) {
        return cellRepository.findByXAndY(x, y).get();
    }

    public Cell saveMatrix(Cell cell) {
        return cellRepository.save(new Cell(cell.x(), cell.y(), cell.sectionId()));
    }

    public void deleteById(int x, int y) {
        cellRepository.delete(cellRepository.findByXAndY(x, y).get());
    }
}