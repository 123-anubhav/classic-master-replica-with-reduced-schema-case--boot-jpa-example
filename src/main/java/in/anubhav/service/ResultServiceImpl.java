package in.anubhav.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import in.anubhav.db1.entity.ResultFull;
import in.anubhav.db1.jpa.ResultFullRepository;
import in.anubhav.db2.entity.ResultLite;
import in.anubhav.db2.jpa.ResultLiteRepository;

@Service
public class ResultServiceImpl implements IResultService {

	private final ResultFullRepository fullRepo;
	private final ResultLiteRepository liteRepo;

	public ResultServiceImpl(ResultFullRepository fullRepo, ResultLiteRepository liteRepo) {
		this.fullRepo = fullRepo;
		this.liteRepo = liteRepo;
	}

	@Transactional
	public ResultFull saveResult(ResultFull resultFull) {
		// Save full entity in DB1
		ResultFull saved = fullRepo.save(resultFull);

		// Map only required fields to Lite entity
		ResultLite lite = new ResultLite();
		lite.setRouteId(saved.getRouteId());
		lite.setRouteNo(saved.getRouteNo());
		lite.setRouteName(saved.getRouteName());
		lite.setRtId(saved.getRtId());
		lite.setFromStopId(saved.getFromStopId());
		lite.setRouteType(saved.getRouteType());
		lite.setInterStateDistance(saved.getInterStateDistance());
		lite.setPlCd(saved.getPlCd());
		lite.setMdDate(saved.getMdDate());

		// Save lite entity in DB2
		liteRepo.save(lite);

		return saved;
	}
}
