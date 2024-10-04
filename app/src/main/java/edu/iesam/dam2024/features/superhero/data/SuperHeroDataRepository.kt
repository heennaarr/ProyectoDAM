package edu.iesam.dam2024.features.superhero.data

import SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.features.superhero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import edu.iesam.dam2024.features.superhero.domain.SuperHeroRepository

class SuperHeroDataRepository (
    private val superHeroDataSource: SuperHeroMockRemoteDataSource,
    private val local: SuperHeroXmlLocalDataSource
):SuperHeroRepository {
    override fun getSuperHeroes(): List<SuperHero> {
        val superHeroFromLocal = local.findAll()
        return if(superHeroFromLocal.isEmpty()){
            val superheroFromRemote = superHeroDataSource.getSuperheroes()
            local.saveAll(superheroFromRemote)
            superheroFromRemote
        }else{
            superHeroFromLocal
        }
    }

    override fun getSuperHeroSelected(superHeroId: String): SuperHero? {
        val localSuperHero = local.findById(superHeroId)
        if(localSuperHero==null){
            superHeroDataSource.getSuperHeroSelected(superHeroId)?.let{
                local.save(it)
                return it
            }
        }
        return localSuperHero
    }


}