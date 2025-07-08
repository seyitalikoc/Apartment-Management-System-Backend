package com.seyitkoc.service.base;

import com.seyitkoc.entity.PollOption;
import com.seyitkoc.repository.PollOptionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class PollOptionBaseService {
    private final PollOptionRepository pollOptionRepository;

    public PollOptionBaseService(PollOptionRepository pollOptionRepository) {
        this.pollOptionRepository = pollOptionRepository;
    }

    public Page<PollOption> getPollOptionsByPollId(
            Long pollId, int page, int pageSize, String sortBy, String sortDirection){
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        Specification<PollOption> specification = (
                (root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("poll").get("id"), pollId));
        return pollOptionRepository.findAll(specification, pageRequest);
    }

}
