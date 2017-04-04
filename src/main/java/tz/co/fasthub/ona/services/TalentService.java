package tz.co.fasthub.ona.services;

import tz.co.fasthub.ona.entities.Talent;

public interface TalentService {

    Iterable<Talent> listAllTalent();

    Talent getTalentById(Integer id);

    Talent saveTalent(Talent talent);

    void deleteTalent(Integer id);

}
